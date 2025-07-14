import { useState } from 'react';
import './App.css';

function App() {

  const [activeTab, setActiveTab] = useState('ask-ai');

  const handleTabChange = (tab) => {
    //alert(tab);
    setActiveTab(tab);
  }

  return (
    <div className="App">
      
      //Botão de pergunte para o AI
      <button 
        className={activeTab === 'ask-ai' ? 'active' : ''}
        onClick={() => handleTabChange('ask-ai')}>
        Talk With AI
      </button>

      //Botão de gerador de receitas
      <button 
       className={activeTab === 'recipe-generator' ? 'active' : ''}
       onClick={() => handleTabChange('recipe-generator')}>
        Generate Recipes
      </button>

      <div>
        {activeTab === 'ask-ai' && <h2>Talk With AI</h2>}
        {activeTab === 'recipe-generator' && <h2>Generate Recipes</h2>}
      </div>


    </div>
  );
}

export default App;
