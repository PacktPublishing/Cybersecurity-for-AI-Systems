from flask import Flask, render_template, request
import openai
import os
from dotenv import load_dotenv

load_dotenv()
openai.api_key = os.getenv("OPENAI_API_KEY")
MODEL = os.getenv("LLM_MODEL", "gpt-4")

app = Flask(__name__)

def get_completion(prompt, model=MODEL):
    messages = [{"role": "user", "content": prompt}]
    response = openai.ChatCompletion.create(
        model=model,
        messages=messages,
        temperature=0
    )
    return response.choices[0].message["content"]

@app.route("/", methods=["GET", "POST"])
def index():
    result = ""
    if request.method == "POST":
        prompt = request.form["prompt"]
        result = get_completion(prompt)
    return render_template("index.html", result=result)

if __name__ == "__main__":
    app.run(debug=True)
