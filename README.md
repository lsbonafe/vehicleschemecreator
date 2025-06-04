
A renderer for generic JSON structures representing vehicle schemes—ranging from cars and buses to rockets or anything your imagination can create.

The vehicle scheme data model is flexible and supports various vertical and horizontal configurations, with multiple decks and levels.

A simple example is shown below.


<img
  src="https://github.com/user-attachments/assets/ee3908e4-518d-48e7-b8c0-50491bd4b45f"
  alt="Screenshot_20250604_151717"
  width="300"
/>


```
{
  "vehicleType": "rocket",
  "decks": [
    {
      "baseDeckLevel": 0,
      "levels": [
        {
          "columns": 4,
          "rows": 5,
          "slots": [
            {
              "type": "element",
              "row": 0,
              "column": 0,
              "contentDescription": "Control Panel",
              "icon": "🎛️"
            },
            {
              "type": "element",
              "row": 0,
              "column": 1,
              "contentDescription": "Gap",
              "icon": "⬜"
            },
            {
              "type": "element",
              "row": 0,
              "column": 2,
              "contentDescription": "Gap",
              "icon": "⬜"
            },
            {
              "type": "element",
              "row": 0,
              "column": 3,
              "contentDescription": "Control Panel",
              "icon": "🎛️"
            },
            {
              "type": "element",
              "row": 1,
              "column": 0,
              "contentDescription": "Window",
              "icon": "🪟"
            },
            {
              "type": "seat",
              "row": 1,
              "column": 1,
              "seatInfo": "Pilot",
              "isTaken": false,
              "category": "premium",
              "color": "#FFD700",
              "icon": "🪑"
            },
            {
              "type": "seat",
              "row": 1,
              "column": 2,
              "seatInfo": "Co-Pilot",
              "isTaken": false,
              "category": "premium",
              "color": "#FFD700",
              "icon": "🪑"
            },
            {
              "type": "element",
              "row": 1,
              "column": 3,
              "contentDescription": "Window",
              "icon": "🪟"
            },
            {
              "type": "element",
              "row": 2,
              "column": 0,
              "contentDescription": "Window",
              "icon": "🪟"
            },
            {
              "type": "seat",
              "row": 2,
              "column": 1,
              "seatInfo": "Astronaut 1",
              "isTaken": false,
              "category": "premium",
              "color": "#FFD700",
              "icon": "🪑"
            },
            {
              "type": "seat",
              "row": 2,
              "column": 2,
              "seatInfo": "Astronaut 2",
              "isTaken": false,
              "category": "premium",
              "color": "#FFD700",
              "icon": "🪑"
            },
            {
              "type": "element",
              "row": 2,
              "column": 3,
              "contentDescription": "Window",
              "icon": "🪟"
            },
            {
              "type": "element",
              "row": 3,
              "column": 0,
              "contentDescription": "Window",
              "icon": "🪟"
            },
            {
              "type": "seat",
              "row": 3,
              "column": 1,
              "seatInfo": "Astronaut 3",
              "isTaken": false,
              "category": "premium",
              "color": "#FFD700",
              "icon": "🪑"
            },
            {
              "type": "seat",
              "row": 3,
              "column": 2,
              "seatInfo": "Astronaut 4",
              "isTaken": false,
              "category": "premium",
              "color": "#FFD700",
              "icon": "🪑"
            },
            {
              "type": "element",
              "row": 3,
              "column": 3,
              "contentDescription": "Window",
              "icon": "🪟"
            },
            {
              "type": "element",
              "row": 4,
              "column": 0,
              "contentDescription": "Turbine",
              "icon": "🔥"
            },
            {
              "type": "element",
              "row": 4,
              "column": 1,
              "contentDescription": "Turbine",
              "icon": "🔥"
            },
            {
              "type": "element",
              "row": 4,
              "column": 2,
              "contentDescription": "Turbine",
              "icon": "🔥"
            },
            {
              "type": "element",
              "row": 4,
              "column": 3,
              "contentDescription": "Turbine",
              "icon": "🔥"
            }
          ]
        }
      ]
    }
  ]
}
```
