
A renderer for generic JSON structures representing vehicle schemes—ranging from cars and buses to rockets or anything your imagination can create.

The vehicle scheme data model is flexible and supports various vertical and horizontal configurations, with multiple decks and levels.

A simple example is shown below.

```
{
  "vehicleType": "car",
  "decks": [
    {
      "baseDeckLevel": 0,
      "levels": [
        {
          "columns": 3,
          "rows": 2,
          "slots": [
            {
              "type": "element",
              "row": 0,
              "column": 0,

              "contentDescription": "Wheel",
              "icon": "⚙️"
            },
            {
              "type": "element",
              "row": 0,
              "column": 1,
              "contentDescription": "Gap",
              "icon": "⬜"
            },
            {
              "type": "seat",
              "row": 0,
              "column": 2,
              "seatInfo": "Passenger",
              "isTaken": false,
              "category": "standard",
              "color": "#000000",
              "icon": "🪑"
            },
            {
              "type": "seat",
              "row": 1,
              "column": 0,
              "seatInfo": "Rear Left",
              "isTaken": false,
              "category": "standard",
              "color": "#000000",
              "icon": "🪑"
            },
            {
              "type": "seat",
              "row": 1,
              "column": 1,
              "seatInfo": "Rear Center",
              "isTaken": false,
              "category": "standard",
              "color": "#000000",
              "icon": "🪑"
            },
            {
              "type": "seat",
              "row": 1,
              "column": 2,
              "seatInfo": "Rear Right",
              "isTaken": false,
              "category": "standard",
              "color": "#000000",
              "icon": "🪑"
            }
          ]
        }
      ]
    }
  ]
}

```
