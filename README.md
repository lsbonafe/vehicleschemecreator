
Generic json structure for vehicle scheme
---

```
{
"vehicleScheme": {
"vehicleType": "string",        // Type of the vehicle (e.g., "bus", "train", "airplane")
"decks": [
{
"baseDeckLevel": "int",     // The base level of this deck (e.g., 0, 1)
"levels": [
{
"columns": "int",       // Number of columns in this level
"rows": "int",          // Number of rows in this level
"slots": [
{
"type": "string",   // Type of slot ("seat" or "element")
"row": "int",       // The row index of the slot (0-based)
"column": "int",    // The column index of the slot (0-based)
// For type "seat"
"seatInfo": "string or null",   // Information about the seat (e.g., "1A"), nullable
"isTaken": "boolean",           // Whether the seat is occupied or not
"category": "string or null",   // Category of the seat (e.g., "standard", "premium"), nullable
"color": "string",              // Color in hex code (e.g., "#0000FF")
"icon": "string",               // Icon representing the seat (e.g., emoji or URL)

                // For type "element"
                "contentDescription": "string", // Description of the element (e.g., "Gap", "Stairs", "Wheel")
                "icon": "string"                // Icon representing the element (e.g., emoji or URL)
              }
            ]
          }
        ]
      }
    ]
}
}
```