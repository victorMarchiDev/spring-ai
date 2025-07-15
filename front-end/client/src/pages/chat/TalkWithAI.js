import React from "react";
import { useState } from 'react';

function TalkWithAI() {

    const [prompt, setPrompt] = useState('');
    const [chatResponse, setChatResponse] = useState('');

    const askAi = async () => {}

    return (
        <div>
            <h2>Talk with AI</h2>
            
            <input
                type="text"
                value={prompt}
                onChange={(e) => setPrompt(e.target.value)}
                placeholder="Enter a prompt for AI"
            />

            <button onClick={askAi} >Ask AI</button>

            <div className="output">
                <p>{chatResponse}</p>
            </div>

        </div>
    );
}

export default TalkWithAI;