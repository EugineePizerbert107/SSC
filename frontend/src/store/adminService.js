import axios from "axios";
// import Vue from "vue";

class AdminService {
  async addAuthor(author) {
    // let response = await Vue.axios.get("/api/checkUser");
    return axios.post(`api/addAuthor`, author);
  }

  async addBook(book) {
    // let response = await Vue.axios.get("/api/checkUser");
    return axios.post(`api/addBook`, book);
  }

  async getAuthors() {
    // let response = await Vue.axios.get("/api/checkUser");
    return axios.get(`api/authorList`);
  }
}

export default new AdminService();
