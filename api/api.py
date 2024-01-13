from flask import Flask, request
from numpy import loadtxt
import tensorflow as tf
from tensorflow import keras
import numpy as np
# import tf 


model = tf.keras.models.load_model('cost_model.h5')
model.summary()

app = Flask(__name__)

@app.route("/api/predict")
def hello_world():

    args = request.args
    
    print(args)
    insurance = args['ins']
    descrpition = args['desc']

    args = request.args
    user_payer_input = insurance
    user_description_input = descrpition

    # Preprocess payer input
    user_payer_input = tf.constant([user_payer_input])

    # Preprocess description input
    user_description_input = tf.constant([user_description_input])

    user_inputs = {
        "payer": user_payer_input,
        "description": user_description_input
    }

    return model.predict(user_inputs), 200

