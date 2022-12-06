import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    loggedIn: false,
    username: null,
    name: null,
    role: "",
    data: [],
  },
  getters: {},
  mutations: {
    setUserLogin(state, loggedIn) {
      state.loggedIn = loggedIn;
    },
    setUsername(state, username) {
      state.username = username;
    },
    setName(state, name) {
      state.name = name;
    },
    setRole(state, role) {
      state.role = role;
    },
    storeData(state, data) {
      state.data = data;
    },
  },
  actions: {
    setLoginUser({ commit }, payload) {
      commit("setUserLogin", payload.loggedIn);
      commit("setUsername", payload.username);
      commit("setName", payload.name);
      commit("setRole", payload.role);
    },
    clearUser({ commit }) {
      commit("setUserLogin", false);
      commit("setUsername", null);
      commit("setName", null);
      commit("setRole", "");
    },
  },
  modules: {},
});
