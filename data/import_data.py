import predictionio
import argparse
import codecs

def sendData(args):

    client = predictionio.EventClient(
        access_key=args.access_key,
        url=args.url,
        threads=5,
        qsize=500
    )
    file = codecs.open(args.file, "r",encoding='utf-8')
    line = file.readline();
    counter = 1;
    jsonStr = "";
    while line !="":
      line = line.split("\t") #Split by tab [sentence,category]
      response = client.create_event(
        event="$set",
        entity_type="phrase",
        entity_id=counter,
        properties= { "phrase" : line[1],
                     "Interest" : line[0]
        }
      )
      counter+=1;
      line = file.readline();

    print str(counter) + " lines have been processed"

if __name__ == '__main__':
  parser = argparse.ArgumentParser(
    description="Import sample data for classification engine")
  parser.add_argument('--access_key', default='invald_access_key')
  parser.add_argument('--url', default="http://localhost:7070")
  parser.add_argument('--file', default="data.json")

  args = parser.parse_args()
  print args
  sendData(args)