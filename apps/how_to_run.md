1. **Navigate to the specific lab folder**
2. **Activate the Virtual Environment**
   - Activate the new virtual environment using:
     ```sh
     source myenv/bin/activate
     ```
     
3. Run `python app.py`
   And Open your browser here: http://127.0.0.1:5000/
4. If the lab is for Jupyter Notebook, **Start Jupyter Notebook**
   - Start Jupyter Notebook with the command:
     ```sh
     jupyter lab         
     ```


### For other labs:
```shell
unzip prompt_app.zip
cd prompt_app
python3 -m venv venv
source venv/bin/activate
pip install -r requirements.txt
export OPENAI_API_KEY=your-key
```