import img1 from '../images/img1.png'
import img2 from '../images/img2.png'
import img3 from '../images/img3.png'

const images = [img1, img2, img3];
const DisplayListOfOffices = ({ OfficeList }) => {
    return (
        <div>
            {OfficeList.map((office, index) => {
                const rentClass = office.Rent < 60000 ? 'textRed' : 'textGreen';
                var jsxatt = <img src={images[index]} width="25%" height="25%" alt="Office Space" />
                return (
                    <div >
                        {jsxatt}
                        <h1>Name : {office.Name}</h1>
                        <h1 className={rentClass}>Rent Rs:{office.Rent}</h1>
                        <h1>Address : {office.Address}</h1>
                    </div>
                )
            })}
        </div>

    )
}
export default DisplayListOfOffices; 