<script>

    let user = { loggIn: false};

    function toggle() {
        user.loggIn = !user.loggIn;
    }

</script>

{#if user.loggIn}
<button on:click={toggle}>
    Log out
</button>
{/if}

{#if !user.loggIn}
<button on:click={toggle}>
    Log in
</button>
{/if}