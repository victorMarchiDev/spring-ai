import { useState } from 'react';
import './App.css';
import RecipeGenerator from './pages/chat/recipe/RecipeGenerator';
import TalkWithAI from './pages/chat/TalkWithAI';

function App() {

  const [activeTab, setActiveTab] = useState('ask-ai');

  const handleTabChange = (tab) => {
    //alert(tab);
    setActiveTab(tab);
  }

  return (
    <div className="App">
      {/* Botão de pergunte para o AI */}
      <button 
        className={activeTab === 'ask-ai' ? 'active' : ''}
        onClick={() => handleTabChange('ask-ai')}>
        Talk With AI
      </button>

      {/* Botão de gerador de receitas */}
      <button 
       className={activeTab === 'recipe-generator' ? 'active' : ''}
       onClick={() => handleTabChange('recipe-generator')}>
        Generate Recipes
      </button>

      <div>
        {activeTab === 'ask-ai' && <TalkWithAI />}
        {activeTab === 'recipe-generator' && <RecipeGenerator />}
      </div>


    </div>
  );
}

export default App;
