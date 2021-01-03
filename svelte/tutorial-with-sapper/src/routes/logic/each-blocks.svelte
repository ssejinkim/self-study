<script>
    let cats = [
        { id: "ghpqwhpt", name: 'Keyboard Cat'},
        { id: "asdgqw23", name: 'Maru'},
        { id: "nhguashi", name: 'Henri The Existential Cat'},
    ]
</script>

<h1>The Famous Cats of Youtube</h1>


<ul>
    {#each cats as cat, i}
    <li>
    <a target="_blank" href="https://www.youtube.com/watch?v={cat.id}">
        {i + 1 } : {cat.name}
    </a>
    </li>
    {/each}
</ul>

<ul>
    {#each cats as {id, name}, i}
    <li>
    <a target="_blank" href="https://www.youtube.com/watch?v={id}">
        {i + 1 } : {name}
    </a>
    </li>
    {/each}
</ul>