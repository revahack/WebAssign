import {useState} from "react";
import './App.css';

const App = () => {
  //make a new state variable to store input
  const [input, setInput] = useState('');
  var [list, setList] = useState([]);
  const total = list.length;
  const [comp, setComp] = useState(0);

  //make a function to store input in list and set the input to blank
  const addToList = (input) => {
    //check if input is empty then don't add to list
    if (input === '') {
      return;
    }
    else{
      const item = {sno: total, todo: input, completed: false};
      setList(list.concat(item));
      setInput('');
    }
  };

  //make a function to line through on list item on click and set completed as true
  const addStrike = (index, sno) => {
    //check if item is already completed
    if (list[sno].completed) {
      index.classList.remove = 'is-done';
      list[sno].completed = false;
    }
    else{
      index.classList.add = 'is-done';
      list[sno].completed = true;
    }
    //count the number of completed items
    let completed = 0;
    for (let i = 0; i < list.length; i++) {
      if (list[i].completed === true) {
        completed++;
      }
    }
    setComp(completed);
  };

  return (
    <div className="App">
      <input type="text" value={input} onChange={e => setInput(e.target.value)} required />&nbsp;&nbsp;
      <button onClick={() => addToList(input)}>Add</button>
      <p>
        {total-comp} remaining of {total} tasks.
      </p>
      <ul>
        {list.map(item => <li className={`${item.completed ? "is-done" : ""}`} key={item.sno} onClick={e=>addStrike(e.target, item.sno)} >{item.todo}</li>)}
      </ul>

    </div>
  );
}

export default App;
