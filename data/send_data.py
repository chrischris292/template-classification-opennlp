import predictionio
engine_client = predictionio.EngineClient(url="http://localhost:8000")
print engine_client.send_query({"sentence": "Russell Wilson is a super bowl quarterback"})
