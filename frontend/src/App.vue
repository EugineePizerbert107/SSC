<template>
  <v-app>
    <v-app-bar app color="primary" dark>
      <div class="d-flex align-center">
        <h2>Book Corner</h2>
      </div>

      <v-spacer></v-spacer>
      <!--      <v-btn @click="logout" text v-if="$store.state.loggedIn">-->
      <!--        <span class="mr-2">{{ $store.state.username }}</span>-->
      <!--        <v-icon>mdi-open-in-new</v-icon>-->
      <!--      </v-btn>-->
      <div class="text-center">
        <v-menu
          offset-y
          v-if="$store.state.loggedIn"
          transition="scale-transition"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="primary" dark v-bind="attrs" v-on="on">
              {{ $store.state.username }}
            </v-btn>
          </template>
          <v-list>
            <v-list-item>
              <v-btn @click="reviewPage">My Reviews</v-btn>
            </v-list-item>
            <v-list-item v-if="$store.state.role === 'admin'">
              <v-btn @click="addBook">Add Book</v-btn>
            </v-list-item>
            <v-list-item v-if="$store.state.role === 'admin'">
              <v-btn @click="addAuthor">Add Author</v-btn>
            </v-list-item>
            <v-list-item>
              <v-btn @click="logout">Logout</v-btn>
            </v-list-item>
            <v-list-item>
              <v-btn @click="homePage">Home</v-btn>
            </v-list-item>
          </v-list>
        </v-menu>
      </div>
    </v-app-bar>

    <v-main>
      <router-view />
    </v-main>

    <v-footer dark padless>
      <v-card class="flex" flat tile>
        <v-card-title class="primary">
          <strong class="subheading"
            >Get connected with us on social networks!</strong
          >

          <v-spacer></v-spacer>

          <v-btn v-for="icon in icons" :key="icon" class="mx-4" dark icon>
            <v-icon size="24px">
              {{ icon }}
            </v-icon>
          </v-btn>
        </v-card-title>

        <v-card-text class="py-2 white--text text-center">
          {{ new Date().getFullYear() }} — <strong>Book Corner</strong>
        </v-card-text>
      </v-card>
    </v-footer>
  </v-app>
</template>

<script>
import Vue from "vue";

export default {
  name: "App",

  data: () => ({
    icons: ["mdi-facebook", "mdi-twitter", "mdi-linkedin", "mdi-instagram"],
  }),

  methods: {
    async logout() {
      let resp = await Vue.axios.get("api/logout");
      if (resp.data.success) {
        await this.$router.push({ name: "Login" });
      }
    },
    reviewPage() {
      this.$router.push({ name: "Reviews", params: this.$store.state.name });
    },
    homePage() {
      this.$router.push({ name: "Login" });
    },
    addAuthor() {
      this.$router.push({
        name: "addAuthorForm",
      });
    },
    addBook() {
      this.$router.push({
        name: "addBookForm",
      });
    },
  },
};
</script>
