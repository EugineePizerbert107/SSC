<template>
  <v-container>
    <h2 class="mb-5">Book List</h2>
    <!--    <ul>-->
    <!--      <li>-->
    <!--        <router-link to="/">Go to Home</router-link>-->
    <!--      </li>-->
    <!--      <li>-->
    <!--        <router-link to="/about">Go to About</router-link>-->
    <!--      </li>-->
    <!--      <li>-->
    <!--        <router-link to="/login">Go to Login</router-link>-->
    <!--      </li>-->
    <!--    </ul>-->
    <template class="mb-5">
      <v-carousel
        cycle
        height="500"
        hide-delimiter-background
        show-arrows-on-hover
        hide-delimiters
        :interval="4000"
      >
        <template v-slot:prev="{ on, attrs }">
          <v-btn color="success" v-bind="attrs" v-on="on">Previous slide</v-btn>
        </template>
        <template v-slot:next="{ on, attrs }">
          <v-btn color="info" v-bind="attrs" v-on="on">Next slide</v-btn>
        </template>
        <v-carousel-item v-for="(slide, i) in slides" :key="i" :src="slide.src">
        </v-carousel-item>
      </v-carousel>
    </template>

    <v-simple-table fixed-header class="mt-5 mb-5">
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">Title</th>
            <th class="text-left">Description</th>
            <th class="text-left">Price (Baht)</th>
            <th class="text-left">Release In</th>
            <!--            <th class="text-left">Ratings</th>-->
            <th class="text-left">Author</th>
            <th class="text-left"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="book in books" :key="book.id">
            <td>{{ book.title }}</td>
            <td>{{ book.description }}</td>
            <td>{{ book.price }}</td>
            <td>{{ book.year }}</td>
            <!--            <td>{{ book.ratings }}</td>-->
            <td>{{ book.author.name }}</td>
            <td>
              <v-btn color="warning" @click="createReview(book.id)">
                Add Review
              </v-btn>
              <v-btn class="ml-5"> Check Reviews </v-btn>
            </td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
  </v-container>
</template>

<script>
import books from "@/store/bookService";

export default {
  name: "Home",
  components: {},
  data() {
    return {
      books: [],
      slides: [
        {
          src: "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1468822230i/27408565.jpg",
        },
        {
          src: "https://s26162.pcdn.co/wp-content/uploads/sites/3/2022/11/november-best-crime-fiction-feat.jpg",
        },
        {
          src: "https://i.insider.com/627019210983640018c0b642?width=750&format=jpeg&auto=webp",
        },
        {
          src: "https://meandermagazine.net/wp-content/uploads/2022/04/top-books-2022-3.png",
        },
      ],
    };
  },
  methods: {
    getBooks() {
      books.getBooks().then((response) => {
        this.books = response.data;
      });
    },
    createReview(book_id) {
      this.$router.push({
        name: "createReviewForm",
        params: { book_id: book_id },
      });
    },
  },
  created() {
    this.getBooks();
  },
};
</script>
