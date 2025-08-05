import { useState } from "react";
import '../Styles/styles.css'
function CurrencyConverter() {
    const [amount, setamount] = useState('');
    const [currency, setCurrency] = useState('');
    const handleSubmit = (arg) => {
        alert("Converting to " + currency + " Amount is " + amount*80);
    }
    return (
        <div>
            <h1 className="heading">Currency Converter!!!</h1>
            <form onSubmit={handleSubmit}>
                <div className="inputDiv">
                    <label for='amt'>Amount :</label>
                    <input className="input-box" id='amt' type="text"  value={amount} onChange={(val) => setamount(val.target.value)}></input>
                </div>
                <div className="inputDiv">
                    <label for='curr'>Currency :</label>
                    <textarea id='curr' className="input-box" value={currency} onChange={(curr) => setCurrency(curr.target.value)}/>                
                </div>
                <div className="class-btn"><button className="submit-btn" type="submit">Submit</button></div>
            </form>
        </div>
    )
};
export default CurrencyConverter;