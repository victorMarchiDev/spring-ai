const API_BASE = "http://localhost:8080";

const form = document.getElementById("recipe-form");
const loading = document.getElementById("loading");
const resultDiv = document.getElementById("recipe-result");
const output = document.getElementById("recipe-output");

form.addEventListener("submit", async (e) => {
  e.preventDefault();

  const ingredients = document.getElementById("ingredients").value.trim();
  const cuisine = document.getElementById("cuisine").value;
  const dietaryRestrictions = document.getElementById("diet").value;

  if (!ingredients) {
    alert("Por favor, insira pelo menos um ingrediente!");
    return;
  }

  loading.classList.remove("hidden");
  resultDiv.classList.add("hidden");
  output.textContent = "";

  try {
    const response = await fetch(
      `${API_BASE}/recipe-creator?ingredients=${encodeURIComponent(ingredients)}&cuisine=${encodeURIComponent(cuisine)}&dietaryRestrictions=${encodeURIComponent(dietaryRestrictions)}`
    );

    if (!response.ok) throw new Error("Erro ao gerar receita");

    const text = await response.text();
    output.textContent = text;
    resultDiv.classList.remove("hidden");
  } catch (err) {
    output.textContent = "⚠️ Ocorreu um erro ao gerar a receita. Tente novamente.";
    resultDiv.classList.remove("hidden");
  } finally {
    loading.classList.add("hidden");
  }
});
