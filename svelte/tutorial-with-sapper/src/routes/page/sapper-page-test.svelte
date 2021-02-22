<script>
  import { stores } from "@sapper/app";

  const { page } = stores();

  console.log("page", $page);

  const isActive = (text) => $page.path.indexOf(text) !== -1;
</script>

{isActive("page2")}
