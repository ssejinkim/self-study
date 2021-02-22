<script>
    import DeclaringProps from './declaring-props.svelte';
import DefaultValues from './default-values.svelte';
import Info from './Info.svelte';
import Nested from './Nested.svelte';

    const pkg = {
        name: 'svelte',
        version: 3,
        speed: 'blazing',
        website: 'https://svelte.dev'
    }
</script>

<Info 
    name={pkg.name}
    version={pkg.version}
    speed={pkg.speed}
    website={pkg.website}
/>

<Info 
    {...pkg}
/>

