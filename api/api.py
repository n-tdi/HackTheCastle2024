from flask import Flask, request

app = Flask(__name__)

@app.route("/api/predict")
def hello_world():
    args = request.args
    print(args)
    insurance = args['ins']
    descrpition = args['desc']
    return "Hello, World!" + insurance + descrpition

