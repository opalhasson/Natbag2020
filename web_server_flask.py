#!/usr/bin/python
import subprocess
from flask import Flask, request

app = Flask("my_app1")

@app.route("/departures")
def departures():
    return subprocess.check_output(["java","-classpath",
                                    "C:/Users/Avivit Yehezkel/Desktop/Natbag/bin","Main",
                                    request.args.get('outformat'),
                                    "d",
                                    request.args.get('country'),
                                    request.args.get('city'),
                                    request.args.get('airport'),
                                    request.args.get('airline'),
                                    request.args.get('day1'),
                                    request.args.get('month1'),
                                    request.args.get('year1'),
                                    request.args.get('day2'),
                                    request.args.get('month2'),
                                    request.args.get('year2'),
                                    request.args.get('sunday'),
                                    request.args.get('monday'),
                                    request.args.get('tuesday'),
                                    request.args.get('wednesday'),
                                    request.args.get('thursday'),
                                    request.args.get('friday'),
                                    request.args.get('saturday')])
@app.route("/arrivals")
def arrivals():
    return subprocess.check_output(["java","-classpath",
                                    "C:/Users/Avivit Yehezkel/Desktop/Natbag/bin","Main",
                                    request.args.get('outformat'),
                                    "a",
                                    request.args.get('country'),
                                    request.args.get('city'),
                                    request.args.get('airport'),
                                    request.args.get('airline'),
                                    request.args.get('day1'),
                                    request.args.get('month1'),
                                    request.args.get('year1'),
                                    request.args.get('day2'),
                                    request.args.get('month2'),
                                    request.args.get('year2'),
                                    request.args.get('sunday'),
                                    request.args.get('monday'),
                                    request.args.get('tuesday'),
                                    request.args.get('wednesday'),
                                    request.args.get('thursday'),
                                    request.args.get('friday'),
                                    request.args.get('saturday')])
app.run(port=8000, host="0.0.0.0")