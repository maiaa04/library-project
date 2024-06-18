import React from 'react';
import Grid from '@mui/material/Grid';
import './BookGrid.css';
import Typography from '@mui/material/Typography';
import Book, { BookProps } from '../book/Book';
import { useApi } from '../api/ApiProvider';
import { useEffect, useState } from 'react';
import { useTranslation } from 'react-i18next';

interface BookGridProps {
  books: BookProps[];
  currentPage: number;
  totalItems: number;
  totalPages: number;
  hasMore: boolean;
}

// export default function BookGrid() {
//   const apiClient = useApi();
//   const [allBookData, setBooks]= useState<BookGridProps | null>(null);

//   useEffect(() => {
//     const fetchBooks = async () => {
//       const booksData = await apiClient.getBooks();
//       console.log(booksData.data);
//       setBooks(booksData.data);
//     };
//     fetchBooks();
//   }, [apiClient]);

export default function BookGrid() {
  const apiClient = useApi();

  const { t, i18n } = useTranslation();

  const [books, setAllBooks] = useState<BookProps[]>([]);
  const [loading, setLoading] = useState<boolean>(true);

  useEffect(() => {
    const fetchBooks = async () => {
      try {
        let allBooksData: BookProps[] = [];

        const booksData = await apiClient.getBooks();
        // const books = booksData.data?.books || [];
        // allBooksData = allBooksData.concat(books);

        // setAllBooks(allBooksData);

        if (Array.isArray(booksData.data)) {
          const books = booksData.data || [];
          allBooksData = allBooksData.concat(books);
          setAllBooks(allBooksData);
        } else {
          console.error('Invalid books data:', booksData);
        }
        setLoading(false);
      } catch (error) {
        console.error('Error fetching books:', error);
        setLoading(false);
      }
    };

    fetchBooks();
  }, [apiClient]);

  if (loading) {
    return <div>{'loading'}</div>;
  }

  console.log('books:', books);

  return (
    // <div>
    //   <div className="list-of-books-text">
    //     <Typography variant="h5">List of books</Typography>
    //   </div>
    //    <Grid container spacing={2}>
    //     {books.map((book) => (
    //     <Grid item key={book.bookId} xs={2} sm={2} md={2}>
    //       <div className="book-container">
    //         <Book
    //            bookId={book.bookId}
    //            title={book.title}
    //            author={book.author}
    //            yearPublished={book.yearPublished}
    //            avaliable={book.avaliable}
    //          />
    //        </div>
    //      </Grid>
    //    ))}
    //  </Grid>
    <div>
      <div className="list-of-books-text">
        <Typography variant="h5">{t('listOfBooks')}</Typography>
      </div>
      <Grid container spacing={2}>
        {books.map((book) => (
          <Grid item key={book.bookId} xs={2} sm={2} md={2}>
            <div className="book-container">
              <Book
                bookId={book.bookId}
                title={book.title}
                author={book.author}
                publicationYear={book.publicationYear}
                available={book.available}
              />
            </div>
          </Grid>
        ))}
      </Grid>
    </div>
  );
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
