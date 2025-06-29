CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
interest_rate FLOAT:=0.01;
old_balance NUMBER;
new_balance NUMBER;
BEGIN
    FOR i IN (SELECT * FROM ACCOUNTS) LOOP
        old_balance:=i.BALANCE;
        new_balance:=old_balance+old_balance*interest_rate;
        UPDATE ACCOUNTS
        SET BALANCE=new_balance,
        LASTMODIFIED=SYSDATE
        WHERE ACCOUNTID=i.ACCOUNTID;
        DBMS_OUTPUT.PUT_LINE('OLD BALANCE ' || old_balance || ' UPDATED BALANCE '|| new_balance);
    END LOOP;
    --COMMIT;
END;