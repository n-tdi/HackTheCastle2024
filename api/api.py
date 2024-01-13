from flask import Flask, request
from numpy import loadtxt
from tf import keras
# import tf 


model = tf.keras.load_model('cost_model.h5')
model.summary()

app = Flask(__name__)

@app.route("/api/predict")
def hello_world():
    args = request.args
    print(args)
    insurance = args['ins']
    descrpition = args['desc']
    return model.predict(insurance, descrpition), 200

