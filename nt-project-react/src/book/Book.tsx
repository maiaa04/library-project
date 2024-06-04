import React from 'react';
import { Card, CardContent, Typography } from '@mui/material';
import './Book.css';

export interface BookProps {
  bookId: number,
  title: string,
  author: string,
  yearPublished: number,
  avaliable: boolean
}

export default function Book({ bookId, title, author, yearPublished, avaliable}: BookProps) {
  return (
    <Card className="book">
      <CardContent className="book-details">
        <Typography className="book-title">{title}</Typography>
        <Typography className="book-details-text">
          by {author}, {yearPublished}
        </Typography>
      </CardContent>
    </Card>
  );
}