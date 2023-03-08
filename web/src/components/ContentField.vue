<template>
    <div class="container content-field">
        <div class="card">
            <div class="card-body">
                <h1 style="text-align: center;">PasteBin</h1>
                <h5 style="text-align: center;">Paste from hnitro</h5>
                <slot></slot>
            </div>
        </div>
    </div>
</template>

<script>

</script>

<style scoped>
.content-field {
    margin-top: 20px;
}

.card {
    background-color: rgba(31, 34, 40, 0.3);
}

.card-body {
    background-color: rgba(31, 34, 40, 0.3);
}
</style>