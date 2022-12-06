import axios from "axios";
import Vue from "vue";

class ReviewService {
  async getReview() {
    let response = await Vue.axios.get("/api/checkUser");
    return axios.get(`api/user/${response.data.name}/reviews`);
  }
  async createReview(book_id, review) {
    let response = await Vue.axios.get("/api/checkUser");
    return axios.post(
      `api/createReview/${book_id}/${response.data.name}`,
      review
    );
  }

  async deleteReview(review_id) {
    return axios.delete(`api/deleteReview/${review_id}`);
  }
}

export default new ReviewService();
