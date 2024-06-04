import React from 'react';
import './MeForm.css';
import Me from '../me/Me';
import LoansGrid from '../loans-grid/LoansGrid';


const meData = [
  {
    id: 1,
    name: 'Maja',
    lastname: 'Ludwińska',
    email: '276067@student.pwr.edu.pl',
  },
];

const myLoans = [
  {
    id: 1,
    title: 'Before the Coffee Gets Cold',
    author: 'Toshikazu Kawaguchi',
    yearPublished: 2015,
    loanDate: '2022-01-01',
    dueDate: '2022-02-01',
  },
  {
    id: 2,
    title: "Tales from the Café",
    author: 'Toshikazu Kawaguchi',
    yearPublished: 2017,
    loanDate: '2023-07-20',
    dueDate: '2022-08-20',
  },
  {
    id: 3,
    title: 'Before Your Memory Fades',
    author: 'Toshikazu Kawaguchi',
    yearPublished: 2018,
    loanDate: '2019-02-23',
    dueDate: '2022-02-01',
  },
];

export default function MeForm() {
  const user = meData[0];
  const userLoan = myLoans;

  return (
    <div className="me-form">
      <div className="me">
        <Me
          id={user.id}
          name={user.name}
          lastname={user.lastname}
          email={user.email}
        />
      </div>
      <div className="loans-grid">
        <LoansGrid loans={userLoan} />
      </div>
    </div>
  );
}
