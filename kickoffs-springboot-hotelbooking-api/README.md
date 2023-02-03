# Kickoffs-Springboot-HotelBooking API



# Getting started

# /room/add
Method - POST
Create and adds a hotel. Assume that the request body is always valid.
JSON Body-
{
"roomNo": 101,
"rentAmount":
2500,
"hotelId": 1,
"floorNo": 1
}
201 created


# /rooms/get
return all room objects in the room Table.
/rooms/get? hotelId= {hotel Id}
return all room objects of a particular hotel with given hotel Id.
Method - GET


    "headers": {},
    "body": {
        "id": 1,
        "roomNo": 101,
        "rentAmount": 2500.0,
        "occupied": false,
        "hotelId": 1
    },
    "statusCodeValue": 200,
    "statusCode": "OK"
}

# /rooms/book/{roomid}
Method - PUT
Change the occupied filed of the particular room with given roomId to true/false.

# /rooms/delete/{roomid}
Method - DELETE
Delete the room row with given room id from the table only if the occupied field of that particular room is false. Assume that the path variable is always found.
200 Ok
400 bad request
