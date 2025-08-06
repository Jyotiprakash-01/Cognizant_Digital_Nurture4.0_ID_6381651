
import './App.css';
import { useState } from 'react';
import { books } from './Components/BookDetails';
import { blogs } from './Components/BlogDetails';
import { courses } from './Components/CourseDetails';

function App() {
  const [showBooks, setShowBooks] = useState(true);
  const [showCourses, setShowCourses] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);

  const toggleBooks = () => setShowBooks(!showBooks);
  const toggleCourses = () => setShowCourses(!showCourses);
  const toggleBlogs = () => setShowBlogs(!showBlogs);

  const bookdet = (
    <ul>
      {books.map((book) =>
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      )}
    </ul>
  )
  const content = (
    <ul>
      {blogs.map((blog) =>
        <div key={blog.id}>
          <h1>{blog.title}</h1>
          <h3>{blog.author}</h3>
          <h4 className='text-faded'>{blog.text}</h4>
        </div>
      )}
    </ul>
  )
  const coursedet = (
    <ul>
      {courses.map((courseinfo) =>
        <div key={courseinfo.id}>
          <h1>{courseinfo.course}</h1>
          <h3>{courseinfo.date}</h3>
        </div>
      )}
    </ul>
  )
  return (
    <div className='App'>
      <div className='buttons'>
        <button onClick={toggleCourses}>{showCourses ? 'Show Course' : 'Hide Courses'}</button>
        <button onClick={toggleBooks}>{showBooks ? 'Show Books' : 'Hide Books'}</button>
        <button onClick={toggleBlogs}>{showBlogs ? 'Show Blogs' : 'Hide Blogs'}</button>        
      </div>
      <div className='frame'>
        {showCourses && (<div className='mystyle1'>
          <h1>Course Details</h1>
          {coursedet}
        </div>)}
        {showBooks && (<div className='st2'>
            <h1>Book Details</h1>
            {bookdet}
          </div>)
        }
        {showBlogs && (<div className='v1'>
          <h1>Blog Details</h1>
          {content}
        </div>)}        
      </div>
    </div>
  );
}

export default App;
