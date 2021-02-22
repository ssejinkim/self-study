<script>
  let text = "";
  let count;

  $: count = countText(text);

  const countText = (text) => {
    let textLength = 0;
    for (let i = 0; i < text.length; i++) {
      console.log(text.charAt(i));
      let char = text.charAt(i);
      console.log(escape(char).length) //한글6 영어1 띄어쓰기3 마침표1
      textLength ++;
    }

    console.log('textLength', textLength)
    return textLength;
  };
</script>

<input type="text" bind:value={text} />

{text}
{count}
