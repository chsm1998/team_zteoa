<html>
<script src="https://cdn.bootcss.com/axios/0.18.0/axios.js"></script>
<body>
<h2>Hello World!</h2>
</body>
<script type="text/javascript">
	axios.post("dept/queryList")
		.then(res => console.log(res))
</script>
</html>
