import React from 'react';
import { Card, CardContent, Typography } from '@mui/material';
import './Book.css';

export interface BookProps {
  bookId: number;
  title: string;
  author: string;
  publicationYear: number;
  available: boolean;
}

export default function Book({
  bookId,
  title,
  author,
  publicationYear,
  available,
}: BookProps) {
  return (
    <Card className="book">
      <CardContent className="book-details">
        <Typography className="book-title">{title}</Typography>
        <Typography className="book-details-text">
          by {author}
        </Typography>
      </CardContent>
    </Card>
  );
}
