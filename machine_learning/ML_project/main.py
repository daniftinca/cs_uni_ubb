# Importing the Keras libraries and packages
import shutil

from keras.models import Sequential
from keras.layers import Conv2D
from keras.layers import MaxPooling2D
from keras.layers import Flatten
from keras.layers import Dense
from keras.preprocessing.image import *
import os
import pandas as pd
import numpy as np
from keras.preprocessing import image

def move_files():
    directory = os.fsencode("C:\\work\\Facultate\\ML\\ML_project\\test_set")
    dirString = "C:\\work\\Facultate\\ML\\ML_project\\test_set"
    data = pd.read_csv('bee_data.csv')
    data = data[['file','health']]
    # print(data.head())
    row = data.loc[data['health'] == 'healthy']
    # print(row)
    for file in os.listdir(directory):
        filename = os.fsdecode(file)
        if filename.endswith(".png"):
            filerow = row[row['file'] == filename]
            if(not filerow.empty):
                print("this bee is healthy")
                target = os.path.join(dirString+"\\healthy\\", filename)
                oldpath = os.path.join(dirString, filename)
                shutil.move(oldpath, target)
            else:
                print("this bee is not healthy")
                target = os.path.join(dirString + "\\unhealthy\\", filename)
                oldpath = os.path.join(dirString, filename)
                shutil.move(oldpath, target)
            continue
        else:
            continue


def do_the_thing():
    print('Initializing classifier...')
    classifier = Sequential()
    classifier.add(Conv2D(32, (3, 3), input_shape=(64, 64, 3), activation='relu'))
    classifier.add(MaxPooling2D(pool_size=(2, 2)))
    classifier.add(Flatten())
    classifier.add(Dense(units=128, activation='relu'))
    classifier.add(Dense(units=1, activation='sigmoid'))
    classifier.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])

    print('Preprocessing images for the model')
    train_datagen = ImageDataGenerator(rescale=1. / 255,
                                       shear_range=0.2,
                                       zoom_range=0.2,
                                       horizontal_flip=True)
    test_datagen = ImageDataGenerator(rescale=1. / 255)
    training_set = train_datagen.flow_from_directory('training_set',
                                                     target_size=(64, 64),
                                                     batch_size=32,
                                                     class_mode='binary')
    test_set = test_datagen.flow_from_directory('test_set',
                                                target_size=(64, 64),
                                                batch_size=32,
                                                class_mode='binary')
    print('Checking for saved weights, model takes a lot of time to train :D ... ')
    if not weights_exist():
        print("Training the model...")
        classifier.fit_generator(training_set,
                                 steps_per_epoch=4363,
                                 epochs=2,
                                 validation_data=test_set,
                                 validation_steps=810)
        classifier.save_weights("weights.h5")
    else:
        print('I FOUND WEIGHTS AM SO HAPPY AND LOADING NOW... ')
        classifier.load_weights("weights.h5")
        print('Weights loaded.')

    return classifier, training_set

def predict(classifier, training_set,path):
    if path=='':
        print("Please give me a path")
        return ''
    else:
        test_image = image.load_img(path, target_size=(64, 64))
        test_image = image.img_to_array(test_image)
        test_image = np.expand_dims(test_image, axis=0)
        result = classifier.predict(test_image)
        print("Class indices: ")
        print(training_set.class_indices)
        print(result[0][0])
        print(result)
        if result[0][0] == 1:
            prediction = 'unhealthy'
        else:
            prediction = 'healthy'
    return prediction

def weights_exist():
    # print('Exists:')
    # print(os.path.exists('weights.h5'))
    return os.path.exists('weights.h5')


classifier,training_set = do_the_thing()
print(predict(classifier,training_set,'C:\\work\\Facultate\\ML\\ML_project\\test_set\\healthy\\046_011.png'))
#TODO accuracy fur 2x2 und 3x3 und 4x4