<template>
    <!-- <nav class="navbar navbar-expand-lg bg-body-tertiary"> -->
    <nav class="navbar navbar-expand-lg navbar-dark ">
        <div class="container">
            <router-link class="navbar-brand" :to="{ name: 'home_index' }">OJ</router-link>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <!-- <a class="nav-link active" aria-current="page" href="/home/">Home</a> -->
                        <router-link :class="route_name == 'home_index' ? 'nav-link active' : 'nav-link'"
                            :to="{ name: 'home_index' }">Home</router-link>
                    </li>
                    <li class="nav-item">
                        <!-- <a class="nav-link active" aria-current="page" href="/problem/">Problem</a> -->
                        <router-link class="nav-link" :to="{ name: 'problem_index' }">Problem</router-link>
                    </li>
                    <li class="nav-item">
                        <!-- <a class="nav-link active" aria-current="page" href="/training/">Training</a> -->
                        <router-link class="nav-link" :to="{ name: 'training_index' }">Training</router-link>
                    </li>
                    <li class="nav-item">
                        <!-- <a class="nav-link active" aria-current="page" href="/contest/">Contest</a> -->
                        <router-link class="nav-link" :to="{ name: 'contest_index' }">Contest</router-link>
                    </li>
                    <li class="nav-item">
                        <!-- <a class="nav-link active" aria-current="page" href="/status/">Status</a> -->
                        <router-link class="nav-link" :to="{ name: 'status_index' }">Status</router-link>
                    </li>
                    <li class="nav-item">
                        <!-- <a class="nav-link active" aria-current="page" href="/discussion/">Discussion</a> -->
                        <router-link class="nav-link" :to="{ name: 'discussion_index' }">Discussion</router-link>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Rank
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/acmrank/">ACM Rank</a></li>
                            <li><a class="dropdown-item" href="/oirank/">OI Rank</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <!-- <a class="nav-link active" aria-current="page" href="/group/">Group</a> -->
                        <router-link class="nav-link" :to="{ name: 'group_index' }">Group</router-link>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            About
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/aboutintroduction/">Introduction</a></li>
                            <li><a class="dropdown-item" href="/aboutdeveloper/">Developer</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                        username
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">my account
                            </a></li>
                        <li><a class="dropdown-item" href="#">exit</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
import { useRoute } from 'vue-router';
import { computed } from 'vue';
export default {
    setup() {
        const route = useRoute();
        let route_name = computed(() => route.name)
        return {
            route_name
        }
    }
}
</script>

<style></style>