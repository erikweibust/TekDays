import com.tekdays.*

class BootStrap {

    def init = { servletContext ->

	 	if ( !TekEvent.get( 1 ) ) {

		new TekUser( 
			fullName:'John Doe',
			userName:'jdoe',
			password:'t0ps3cr3t',
			email:'jdoe@johnsgroovyshop.com',
			website:'blog.johnsgroovyshop.com',
			bio:'John has been programming for over 40 years.').save()

		new TekUser( 
			fullName:'John Deere',
			userName:'tractorman',
			password:'t0ps3cr3t',
			email:'john.deere@porkproducers.org',
			website:'www.perl.porkproducers.org',
			bio:'Jon is a top notch Perl programmer and a pretty good.').save()

	 	def event1 = new TekEvent(
			name:'Gateway Code Camp',
			city:'Saint Louis, MO',
			organizer:TekUser.findByFullName('John Doe'),
			venue:'TBD',
			startDate: new Date( '11/21/2013' ),
			endDate: new Date( '11/21/2013' ),
			description:'''This conference will bring coders from
								across platforms, languages, and industries
								together for an exciting day of tips, tricks,
								and tech! Stay sharp! Stay at the top of your
								game! But, don't stay home! Come and join us
								this fall for the first annual Gateway Code
								Camp.''').save()

		def gl = TekEvent.findByName( 'Gateway Code Camp' )
			gl.addToVolunteers( new TekUser(
				fullName:'Sarah Martin',
				userName:'sarah',
				password:'54321',
				email:'sarah@martinworld.com',
				website:'www.martinworld.com',
				bio:'Web designer and Grails afficianado.' ) )
			gl.addToVolunteers( new TekUser(
				fullName:'Bill Smith',
				userName:'Mr_Bill',
				password:'12345',
				email:'mrbill@email.com',
				website:'www.mrbillswebsite.com',
				bio:'Software developer, claymation artist.' ) )

			gl.addToRespondents( 'ben@grailsmail.com' )
			gl.addToRespondents( 'zachary@linuxgurus.org' )
			gl.addToRespondents( 'solomon@bootstrapwelding.com' )

		gl.save()

		def s1 = new Sponsor(
				name:'Contegix',
				website:'http://www.contegix.com',
				description:'Beyond Managed Hosting for you' ).save()

		def s2 = new Sponsor(
				name:'Object Computing Inc',
				website:'http://ociweb.com',
				description:'An OO software company' ).save()

	 		def sp1 = new Sponsorship(
				event:gl,
				sponsor:s1,
				contributionType:'Other',
				description:'Cool t-shirts' ).save()

	 		def sp2 = new Sponsorship(
				event:gl,
				sponsor:s2,
				contributionType:'Venue',
				description:'Will be paying for the Moscone').save()
		}
    }

    def destroy = {
    }
}
