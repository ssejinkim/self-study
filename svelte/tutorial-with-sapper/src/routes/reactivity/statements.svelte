<script>
    let count = 0;

    function handleClick() {
        count += 1;
    }

    $: console.log(`the count is ${count}`);

    $: {
        console.log(`THE COUNT IS ${count}`);
        // alert is not defined error
        // alert(`I SAID THE COUNT IS ${count}`);
    }

    $: if(count >= 10) {
        alert(`count is dangerously high!`);
        count = 0;
    }

</script>

<button on:click={handleClick}>
    Clicked {count} {count === 1? 'time' : 'tiems'}
</button>