<template>
    <div>
        <h1>{{ msg }}</h1>
        <h2>{{cc}}</h2>
        <el-button @click="test">test</el-button>
    </div>
</template>

<script>
    export default {
        name: 'HelloWorld2',
        data() {
            return {
                msg: "bbbbb",
                cc: "123"
            }
        },
        methods: {
            test: function () {
                alert();
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    h3 {
        margin: 40px 0 0;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }
</style>
