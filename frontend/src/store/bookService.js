import axios from "axios";
const BOOKS_LIST_API_URL = "api/bookList";
class BookService {
  getBooks() {
    return axios.get(BOOKS_LIST_API_URL);
  }
}

export default new BookService();
