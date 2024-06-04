import React from "react";
import './Loan.css';
import { Card, CardContent, Typography } from "@mui/material";

export interface LoanProps {
  id: number
  title: string
  author: string
  yearPublished: number
  loanDate: string
  dueDate: string
}

export default function Loan({ id, title, author, yearPublished, loanDate, dueDate }: LoanProps) {

  return (
    <Card className="loan">
      <CardContent className="loan-text">
        <Typography><b>Loan id:</b> {id}</Typography>
        <Typography><b>Title:</b> {title}</Typography>
        <Typography><b>Author:</b> {author}</Typography>
        <Typography><b>Year of publication:</b> {yearPublished}</Typography>
        <Typography><b>Loan date:</b> {loanDate}</Typography>
        <Typography><b>Due date:</b> {dueDate}</Typography>
      </CardContent>
      </Card>
  );
}