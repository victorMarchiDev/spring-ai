import { useState } from 'react';
import './App.css';

function App() {

  const [activeTab, setActiveTab] = useState('ask-ai');

  const handleTabChange = (tab) => {
    alert(tab);
    setActiveTab(tab);
  }

  return (
    <div className="App">
      <button onClick={() => handleTabChange('ask-ai')}>Talk With AI</button>
      <button onClick={() => handleTabChange('recipe-generator')}>Generate Recipe</button>
    </div>
  );
}

export default App;
