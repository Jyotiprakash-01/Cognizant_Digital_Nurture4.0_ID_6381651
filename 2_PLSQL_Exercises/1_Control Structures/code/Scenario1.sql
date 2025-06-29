DECLARE
customer_id CUSTOMERS.CUSTOMERID%TYPE;
customer_DOB CUSTOMERS.DOB%TYPE;
customer_age NUMBER;
total_customer NUMBER;
old_interest_rate NUMBER;
new_interest_rate NUMBER;
BEGIN
    SELECT COUNT(*) INTO total_customer FROM CUSTOMERS;
    FOR i IN 1..total_customer LOOP
        SELECT CUSTOMERID,DOB INTO customer_id,customer_DOB FROM CUSTOMERS WHERE CUSTOMERID=i;
        customer_age:=TRUNC(MONTHS_BETWEEN(SYSDATE,customer_DOB)/12);
        
        IF customer_age >60 THEN
            SELECT INTERESTRATE INTO old_interest_rate FROM LOANS WHERE CUSTOMERID=customer_id;
            UPDATE LOANS
            SET INTERESTRATE=INTERESTRATE-(INTERESTRATE*0.1)
            WHERE CUSTOMERID=customer_id;
            DBMS_OUTPUT.PUT_LINE('DISCOUNT APPLIED');
            SELECT INTERESTRATE INTO new_interest_rate FROM LOANS WHERE CUSTOMERID=customer_id;
            DBMS_OUTPUT.PUT_LINE(customer_id || ', Old Interest Rate ' || old_interest_rate || ', New Interest Rate ' || new_interest_rate);
    
        END IF;
        
    END LOOP;
    COMMIT;
END;