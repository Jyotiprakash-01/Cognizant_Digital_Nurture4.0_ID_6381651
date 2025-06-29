CREATE OR REPLACE PROCEDURE TransferFunds(
    sender_accno IN ACCOUNTS.ACCOUNTID%TYPE,
    receiver_accno IN ACCOUNTS.ACCOUNTID%TYPE,
    amount IN NUMBER   
)
IS
source_bal NUMBER;
insufficient_balance EXCEPTION;
BEGIN
    SELECT BALANCE INTO source_bal FROM ACCOUNTS WHERE ACCOUNTID=sender_accno;
    IF source_bal<amount THEN
        RAISE insufficient_balance;
    ELSE
        UPDATE ACCOUNTS
        SET BALANCE=BALANCE+amount,
        LASTMODIFIED=SYSDATE
        WHERE ACCOUNTID=sender_accno;

        UPDATE ACCOUNTS
        SET BALANCE =BALANCE-amount,
        LASTMODIFIED=SYSDATE
        WHERE ACCOUNTID=receiver_accno;
        
    END IF;
    EXCEPTION
    WHEN insufficient_balance THEN
        DBMS_OUTPUT.PUT_LINE('INSUFFICIENT BALANCE');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('AN EXCEPTION OCCOURED');
END;