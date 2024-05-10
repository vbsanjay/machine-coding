# Call taxi booking application

## Design a Call taxi booking application

### Requirement

- There are n number of taxi’s. For simplicity, assume 4. But it should work for any number of taxi’s. 
- There are 6 points (A,B,C,D,E,F). 
- All the points are in a straight line, and each point is 15kms away from the adjacent points. 
- It takes 60 minutes to travel from one point to another.
- Each taxi charges Rs.100 minimum for the first 5 kilometers and Rs.10 for the subsequent kilometers. 
- For simplicity, time can be entered as absolute time. Eg: 9hrs, 15hrs etc. 
- All taxis are initially stationed at A. 
- When a customer books a Taxi, a free taxi at that point is allocated. 
- If no free taxi is available at that point, a free taxi at the nearest point is allocated. 
- If two taxis are free at the same point, one with lower earning is allocated.
- Note that the taxi only charges the customer from the pickup point to the drop point. Not the distance it travels from an adjacent point to pickup the customer. 
- If no taxi is free at that time, booking is rejected. 

## Design modules for
- Call taxi booking 
  - Input 1:
    - Customer ID: 1 
    - Pickup Point: A 
    - Drop Point: B 
    - Pickup Time: 9 
  - Output 1:
    - Taxi can be allotted. 
    - Taxi-1 is allotted 
  - Input 2:
    - Customer ID: 2 
    - Pickup Point: B 
    - Drop Point: D 
    - Pickup Time: 9 
  - Output 1:
    - Taxi can be allotted. 
    - Taxi-2 is allotted
    - (Note: Since Taxi-1 would have completed its journey when second booking is done, so Taxi-2 from nearest point A which is free is allocated)
  - Input 3:
    - Customer ID: 3 
    - Pickup Point: B 
    - Drop Point: C 
    - Pickup Time: 12
  - Output 1:
    - Taxi can be allotted. 
    - Taxi-1 is allotted.

### Display the Taxi details
- Information to display
  - Taxi No
  - Total Earnings
  - BookingID
  - CustomerID
  - From
  - To    
  - PickupTime    
  - DropTime    
  - Amount 
- Output:
- Taxi-1    
- Total Earnings: Rs. 400 
- BookingID: 1 CustomerID: 1 From: A To: B PickupTime:9 DropTime:10 Amount: 200
- BookingID: 3 CustomerID: 3 From: B To: C PickupTime:12 DropTime:13 Amount: 200

- Taxi-2 
- Total Earnings: Rs. 350
- BookingID: 2 CustomerID: 2 From: B To: D PickupTime:9 DropTime:11 Amount: 350
