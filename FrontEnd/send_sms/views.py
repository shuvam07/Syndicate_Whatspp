from django.shortcuts import render

from django.http import HttpResponseNotFound
from django.shortcuts import render_to_response


# Create your views here.

def send_sms(request):
	print("Here")
	return render(request,'index.html')