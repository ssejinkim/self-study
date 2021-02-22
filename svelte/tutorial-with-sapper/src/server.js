import sirv from 'sirv';
import polka from 'polka';
import compression from 'compression';
import * as sapper from '@sapper/server';

const { PORT, NODE_ENV } = process.env;
const dev = NODE_ENV === 'development';

polka() // You can also use Express
	.use(
		compression({ threshold: 0 }),
		sirv('static', { dev }),
		sapper.middleware(),
		(req, res, next) => {
			console.log('req' ,req)
			next();
		}

	)
	.get('/users/:id', (req, res) => {
		console.log(`~> Hello, ${req.hello}`);
		res.end(`User: ${req.params.id}`);
	  })
	.listen(PORT, err => {
		if (err) console.log('error', err);
	});
