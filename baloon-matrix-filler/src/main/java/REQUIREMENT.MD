1. Given a MxN matrix filled with ‘-‘ and you need to drop the balloons in the
   desired columns starting from the bottom. You need to print the matrix when a new
   balloon is dropped.
   You need to continue getting inputs until the box is full or until the user chooses
   to stop.
   TEST CASE :
   Enter the matrix size(m*n)  :  3 3
   Enter the column number    :  2
   Enter the color of the balloon : R Contents of the matrix :
-- -
-- -
-R -
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : B Contents of the matrix :
-- -
-B -
-R -
Do you wish to continue(Y/N) : Y Enter the column number : 1 Enter the color of the balloon : R Contents of the matrix :
-- -
-B -
RR -
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : R Contents of the matrix :
-R -
-B -
RR -
Do you wish to continue(Y/N) : N Program Stopped
2. Extended version of the previous problem. Now you need to quit when a row become
   filled completely.
   TEST CASE :
   Enter the matrix size(m*n)  :  3 3
   Enter the column number    :  2
   Enter the color of the balloon  :  R
   Contents of the matrix    :
-- -
-- -
-R -
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : B Contents of the matrix :
-- -
-B -
-R -
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : R Contents of the matrix :
-R -
-B -
-R -
Column is filled completely. Program is terminated.
3. Extended version of the previous problem. Now you need to drop balloon in the
   first free cell from left if the specified column is filled in every row.

TEST CASE :
Enter the matrix size(m*n)  :  3 3
Enter the column number    :  2
Enter the color of the balloon  :  R
Contents of the matrix    :
-- -
-- -
-R -
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : B Contents of the matrix :
-- -
-- -
BR -
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : R Contents of the matrix :
-- -
-- -
BR R
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : R Contents of the matrix :
-- -
-R -
BR R
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : B Contents of the matrix :
-- -
BR -
BR R
Do you wish to continue(Y/N) : N Program terminated.
4. Extended version of the previous problem. If any column has three continuous
   balloons of same colors then we need to burst them.
   TEST CASE :
   Enter the matrix size(m*n)  :  3 3
   Enter the column number    :  2
   Enter the color of the balloon  :  R
   Contents of the matrix    :
-- -
-- -
-R -
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : R Contents of the matrix :
-- -
-- -
RR -
Do you wish to continue(Y/N) : Y

Enter the column number : 2 Enter the color of the balloon : R Contents of the matrix :
-- -
-- -
RR R
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : R Contents of the matrix :
-- -
-R -
RR R
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : B Contents of the matrix :
-- -
RR -
RR R
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : R Contents of the matrix :
-- -
RR R
RR R
Do you wish to continue(Y/N) : Y Enter the column number : 2 Enter the color of the balloon : R Contents of the matrix :
-- -
R- R
R- R
Do you wish to continue(Y/N) : N Program Terminated.
5. Extended version of the previous problem. Now you need to burst the three
   continuous colors in the same row.