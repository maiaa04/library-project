import React from 'react';
import Grid from '@mui/material/Grid';
import './BookGrid.css';
import Typography from '@mui/material/Typography';
import Book, { BookProps } from '../book/Book';
import { useApi } from '../api/ApiProvider';
import { Key, useEffect, useState } from 'react';

interface BookGridProps{
  books: BookProps[],
  currentPage: number,
  totalItems: number,
  totalPages: number,
  hasMore: boolean
}


export default function BookGrid() {
  const apiClient = useApi();
  const [allBookData, setBooks]= useState<BookGridProps | null>(null);

  useEffect(() => {
    const fetchBooks = async () => {
      const booksData = await apiClient.getBooks();
      console.log(booksData.data);
      setBooks(booksData.data);
    };
    fetchBooks();
  }, [apiClient]);

  if(!allBookData){
    return <div>Loading...</div>
  }

  const books= allBookData!.books;
  console.log('books:', books);

  return (
    <div>
      <div className="list-of-books-text">
        <Typography variant="h5">List of books</Typography>
      </div>
       <Grid container spacing={2}>
        {books.map((book) => (
        <Grid item key={book.bookId} xs={2} sm={2} md={2}>
          <div className="book-container">
            <Book
               bookId={book.bookId}
               title={book.title}
               author={book.author}
               yearPublished={book.yearPublished}
               avaliable={book.avaliable}
             />
           </div>
         </Grid>
       ))}
     </Grid>
     </div>
  )
}

// function BookGrid() {
//   return (
//     <div>
//       <div className="list-of-books-text">
//         <Typography variant="h5">List of books</Typography>
//       </div>
//        <Grid container spacing={2}>
//       {books.map((book) => (
//         <Grid item key={book.id} xs={2} sm={2} md={2}>
//           <div className="book-container">
//             <Book
//               id={book.id}
//               title={book.title}
//               author={book.author}
//               yearPublished={book.yearPublished}
//               photo={book.photo}
//               avaliableCopies={book.avaliableCopies}
//             />
//           </div>
//         </Grid>
//       ))}
//     </Grid>
//     </div>
//   );
// }

// export default BookGrid;
