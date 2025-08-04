import React from "react";

export function ListOfPlayers({ players }) {
    return (
        players.map((item) => {
            return (
                <div>
                    <li>Mr.{item.name}<span> {item.score}</span></li>
                </div>
            )
        })
    )
}

function filterPlayers({ players }) {
    const player70 = []

    players.map((item) => {
        if (item.score <= 70) {
            player70.push(item)

        }
        return null
    })
    return player70
}

export function Scorebelow70({ players }) {
    var playersScoreUnder70 = filterPlayers({ players })
    return (
        playersScoreUnder70.map((item) => {
            return (
                <div>
                    <li>Mr.{item.name}<span> {item.score}</span></li>
                </div>
            )
        })
    )
}
export function ListOfIndianPlayers({ IndianPlayers }) {
    return (
        IndianPlayers.map((item) => {
            return (
                <div>
                    <li>Mr.{item}</li>
                </div>
            )
        })
    )
}
